  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
    .globl _main

_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting i0 = 5
          # Emitting i0
          movl -4(%ebp), %edi
          # Emitting 5
          movl $5, %edi
        movl %edi, -4(%ebp)
        # Emitting i1 = 2
          # Emitting i1
          movl -8(%ebp), %edi
          # Emitting 2
          movl $2, %edi
        movl %edi, -8(%ebp)
        # Emitting r1 = (i1 * 3)
          # Emitting r1
          movl -36(%ebp), %edi
          # Emitting (i1 * 3)
            # Emitting i1
            movl -8(%ebp), %edi
            # Emitting 3
            movl $3, %esi
          pushl %edi
          pushl %esi
          movl 4(%esp), %edi
          imull 0(%esp), %edi
        movl %edi, -36(%ebp)
        # Emitting write(r1)
          # Emitting r1
          movl -36(%ebp), %edi
        pushl %edi
        call _printf
        # Emitting writeln()
        pushl $.LC1
        call _printf
        # Emitting r1 = (i0 * i1)
          # Emitting r1
          movl -36(%ebp), %edi
          # Emitting (i0 * i1)
            # Emitting i0
            movl -4(%ebp), %edi
            # Emitting i1
            movl -8(%ebp), %edx
          pushl %edi
          pushl %edx
          movl 4(%esp), %edi
          imull 0(%esp), %edi
        movl %edi, -36(%ebp)
        # Emitting write(r1)
          # Emitting r1
          movl -36(%ebp), %edi
        pushl %edi
        call _printf
        # Emitting writeln()
        pushl $.LC1
        call _printf
        # Emitting r1 = (((r1 * i0) * i1) * 3)
          # Emitting r1
          movl -36(%ebp), %edi
          # Emitting (((r1 * i0) * i1) * 3)
            # Emitting ((r1 * i0) * i1)
              # Emitting (r1 * i0)
                # Emitting r1
                movl -36(%ebp), %edi
                # Emitting i0
                movl -4(%ebp), %ecx
              pushl %edi
              pushl %ecx
              movl 4(%esp), %edi
              imull 0(%esp), %edi
              # Emitting i1
              movl -8(%ebp), %ebx
            pushl %edi
            pushl %ebx
            movl 4(%esp), %edi
            imull 0(%esp), %edi
            # Emitting 3
            movl $3, %eax
          pushl %edi
          pushl %eax
          movl 4(%esp), %edi
          imull 0(%esp), %edi
        movl %edi, -36(%ebp)
        # Emitting write(r1)
          # Emitting r1
          movl -36(%ebp), %edi
        pushl %edi
        call _printf
        # Emitting writeln()
        pushl $.LC1
        call _printf
    movl $0, %eax
    leave
    ret
