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
          # Emitting 5
          movl $5, %edi
          # Emitting i0
          subl $4, %esp
        movl %edi, -4(%ebp)
        # Emitting i1 = 2
          # Emitting 2
          movl $2, %esi
          # Emitting i1
          subl $4, %esp
        movl %esi, -8(%ebp)
        # Emitting r1 = (i1 * 3)
          # Emitting (i1 * 3)
            # Emitting i1
            movl -8(%ebp), %edi
            # Emitting 3
            movl $3, %esi
          imull %esi, %edi
          # Emitting r1
          subl $4, %esp
        movl %edi, -12(%ebp)
        # Emitting write(r1)
          # Emitting r1
          movl -12(%ebp), %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting r1 = (i0 * i1)
          # Emitting (i0 * i1)
            # Emitting i0
            movl -4(%ebp), %esi
            # Emitting i1
            movl -8(%ebp), %edi
          imull %edi, %esi
          # Emitting r1
          movl -12(%ebp), %edi
        movl %esi, -12(%ebp)
        # Emitting write(r1)
          # Emitting r1
          movl -12(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting r1 = (((r1 * i0) * i1) * 3)
          # Emitting (((r1 * i0) * i1) * 3)
            # Emitting ((r1 * i0) * i1)
              # Emitting (r1 * i0)
                # Emitting r1
                movl -12(%ebp), %edi
                # Emitting i0
                movl -4(%ebp), %esi
              imull %esi, %edi
              # Emitting i1
              movl -8(%ebp), %esi
            imull %esi, %edi
            # Emitting 3
            movl $3, %esi
          imull %esi, %edi
          # Emitting r1
          movl -12(%ebp), %esi
        movl %edi, -12(%ebp)
        # Emitting write(r1)
          # Emitting r1
          movl -12(%ebp), %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
