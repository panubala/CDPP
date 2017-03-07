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
          addl $-4, %esp
          # Emitting 5
          movl $5, %esi
        movl %esi, -4(%ebp)
        # Emitting i1 = 2
          # Emitting i1
          addl $-4, %esp
          # Emitting 2
          movl $2, %esi
        movl %esi, -8(%ebp)
        # Emitting r1 = (i1 * 3)
          # Emitting r1
          addl $-4, %esp
          # Emitting (i1 * 3)
            # Emitting i1
            movl -8(%ebp), %esi
            # Emitting 3
            movl $3, %edx
          pushl %esi
          pushl %edx
          movl 4(%esp), %esi
          imull 0(%esp), %esi
        movl %esi, -12(%ebp)
        # Emitting write(r1)
          # Emitting r1
          movl -12(%ebp), %edi
        pushl %edi
        call _printf
        # Emitting writeln()
        pushl $.LC1
        call _printf
        # Emitting r1 = (i0 * i1)
          # Emitting r1
          movl -12(%ebp), %edi
          # Emitting (i0 * i1)
            # Emitting i0
            movl -4(%ebp), %esi
            # Emitting i1
            movl -8(%ebp), %ecx
          pushl %esi
          pushl %ecx
          movl 4(%esp), %esi
          imull 0(%esp), %esi
        movl %esi, -12(%ebp)
        # Emitting write(r1)
          # Emitting r1
          movl -12(%ebp), %edi
        pushl %edi
        call _printf
        # Emitting writeln()
        pushl $.LC1
        call _printf
        # Emitting r1 = (((r1 * i0) * i1) * 3)
          # Emitting r1
          movl -12(%ebp), %edi
          # Emitting (((r1 * i0) * i1) * 3)
            # Emitting ((r1 * i0) * i1)
              # Emitting (r1 * i0)
                # Emitting r1
                movl -12(%ebp), %esi
                # Emitting i0
                movl -4(%ebp), %ebx
              pushl %esi
              pushl %ebx
              movl 4(%esp), %esi
              imull 0(%esp), %esi
              # Emitting i1
              movl -8(%ebp), %eax
            pushl %esi
            pushl %eax
            movl 4(%esp), %esi
            imull 0(%esp), %esi
            # Emitting 3
