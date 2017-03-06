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
        # Emitting i1 = read()
          # Emitting i1
          movl -8(%ebp), %edi
          # Emitting read()
          pushl %esp
          call _scanf
          movl 0(%esp), %edi
        movl %edi, -8(%ebp)
        # Emitting r1 = (i0 + i1)
          # Emitting r1
          movl -36(%ebp), %edi
          # Emitting (i0 + i1)
            # Emitting i0
            movl -4(%ebp), %edi
            # Emitting i1
            movl -8(%ebp), %esi
          pushl %edi
          pushl %esi
          movl 4(%esp), %edi
          addl 0(%esp), %edi
        movl %edi, -36(%ebp)
        # Emitting write(r1)
          # Emitting r1
          movl -36(%ebp), %edi
        pushl %edi
        call _printf
        # Emitting writeln()
        pushl $.LC1
        call _printf
        # Emitting write((r1 - 3))
          # Emitting (r1 - 3)
            # Emitting r1
            movl -36(%ebp), %edi
            # Emitting 3
            movl $3, %edx
          pushl %edi
          pushl %edx
          movl 4(%esp), %edi
          subl 0(%esp), %edi
        pushl %edi
        call _printf
        # Emitting writeln()
        pushl $.LC1
        call _printf
    movl $0, %eax
    leave
    ret
